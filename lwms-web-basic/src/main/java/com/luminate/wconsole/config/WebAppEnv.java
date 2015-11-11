package com.luminate.wconsole.config;

/**
 * The configuration class to save the properties from command line
 * 
 * @author wangwei
 *
 */
public class WebAppEnv {
  // data feed in json format
  public final static int DATA_REST = 1;
  // data feed from rpc service
  public final static int DATA_RPC = 2;
  // default jetty server port is 8080
  private static int jettyPort = 8080;
  // default data type is json
  private static int dataType = DATA_REST;

  public static int getJettyPort() {
    return jettyPort;
  }

  public static void setJettyPort(int jettyPort) {
    WebAppEnv.jettyPort = jettyPort;
  }

  public static int getDataType() {
    return dataType;
  }

  public static void setDataType(int dataType) {
    WebAppEnv.dataType = dataType;
  }

}
