java_library(
  name = "service",
  visibility = ["//visibility:public"],
  srcs = glob(["**/*.java"]),
  deps = [
  		"//src/main/java/com/luminate/wconsole/config:config",
        "@org/springframework/spring-context//jar",
        "@org/springframework/spring-beans//jar",
        "@org/springframework/spring-core//jar",
        "@com/google/protobuf/protobuf-java//jar",
        "@org/slf4j/slf4j-api//jar",
        "//lib/grpc_netty",
		"//lib/grpc_core",
		"//lib/grpc_auth",
		"//lib/grpc_okhttp",
		"//lib/grpc_protobuf",
		"//lib/grpc_stub",
		"//lib/jsr305_annotations",
		"//lib/proto_ap:ap_proto_java"
  ],
)