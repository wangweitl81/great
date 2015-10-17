package com.luminate.wconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.common.base.Strings;
import com.luminate.wconsole.config.RootConfiguration;
import com.luminate.wconsole.config.WebAppEnv;

/**
 * Application entry point.
 *
 * This class implements and bootstraps the Spring application context. It also
 * listens for application events to ensure the SpringMVC application context is
 * successfully loaded.
 */
public class Main {
  @Parameter(names = { "-jettyPort" }, description = "Jetty Port")
  private int jettyPort;

  @Parameter(names = { "-dataType" }, description = "Data Type")
  private String dataType;

  /**
   * Flag that will be set to true when the web application context (SpringMVC)
   * is refreshed.
   */
  static boolean webApplicationContextInitialized = false;

  public static void main(String[] args) throws Exception {

	final Logger logger = LoggerFactory.getLogger("main");

	Main main = new Main();
	if (args.length > 0) {
	  new JCommander(main, args);

	  if (main.jettyPort > 0) {
		WebAppEnv.setJettyPort(main.jettyPort);
	  }
	  if (!Strings.isNullOrEmpty(main.dataType)) {
		if (main.dataType.equals("rest")) {
		  WebAppEnv.setDataType(WebAppEnv.DATA_REST);
		} else if (main.dataType.equals("grpc")) {
		  WebAppEnv.setDataType(WebAppEnv.DATA_RPC);
		}
	  }
	}

	logger.info("Jetty server has started at port: " + WebAppEnv.getJettyPort());

	try {
	  AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

	  /*
	   * One problem with SpringMVC is it creates its own application context,
	   * and so it can end up failing but our application will keep running.
	   * 
	   * To detect the case where the SpringMVC's web application context fails
	   * we'll listen for ContextRefreshEvents and set a flag when we see one.
	   */
	  applicationContext.addApplicationListener(new ApplicationListener<ContextRefreshedEvent>() {
		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
		  ApplicationContext ctx = event.getApplicationContext();
		  if (ctx instanceof AnnotationConfigWebApplicationContext) {
			webApplicationContextInitialized = true;
		  }
		}
	  });

	  applicationContext.registerShutdownHook();
	  applicationContext.register(RootConfiguration.class);
	  applicationContext.refresh();

	  if (!webApplicationContextInitialized) {
		logger.error("Web application context not initialized. Exiting.");
		System.exit(1);
	  }

	  logger.info("Running.");
	} catch (Exception e) {
	  logger.error("Error starting application", e);
	  System.exit(1);
	}
  }
}
