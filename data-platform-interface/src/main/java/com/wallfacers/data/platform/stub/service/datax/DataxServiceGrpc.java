package com.wallfacers.data.platform.stub.service.datax;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.1)",
    comments = "Source: DataxService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataxServiceGrpc {

  private DataxServiceGrpc() {}

  public static final String SERVICE_NAME = "DataxServiceProto.DataxService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest,
      com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> getRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "run",
      requestType = com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest.class,
      responseType = com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest,
      com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> getRunMethod() {
    io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest, com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> getRunMethod;
    if ((getRunMethod = DataxServiceGrpc.getRunMethod) == null) {
      synchronized (DataxServiceGrpc.class) {
        if ((getRunMethod = DataxServiceGrpc.getRunMethod) == null) {
          DataxServiceGrpc.getRunMethod = getRunMethod =
              io.grpc.MethodDescriptor.<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest, com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "run"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataxServiceMethodDescriptorSupplier("run"))
              .build();
        }
      }
    }
    return getRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest,
      com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> getStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stop",
      requestType = com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest.class,
      responseType = com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest,
      com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> getStopMethod() {
    io.grpc.MethodDescriptor<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest, com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> getStopMethod;
    if ((getStopMethod = DataxServiceGrpc.getStopMethod) == null) {
      synchronized (DataxServiceGrpc.class) {
        if ((getStopMethod = DataxServiceGrpc.getStopMethod) == null) {
          DataxServiceGrpc.getStopMethod = getStopMethod =
              io.grpc.MethodDescriptor.<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest, com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "stop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataxServiceMethodDescriptorSupplier("stop"))
              .build();
        }
      }
    }
    return getStopMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataxServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataxServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataxServiceStub>() {
        @java.lang.Override
        public DataxServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataxServiceStub(channel, callOptions);
        }
      };
    return DataxServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataxServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataxServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataxServiceBlockingStub>() {
        @java.lang.Override
        public DataxServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataxServiceBlockingStub(channel, callOptions);
        }
      };
    return DataxServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataxServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataxServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataxServiceFutureStub>() {
        @java.lang.Override
        public DataxServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataxServiceFutureStub(channel, callOptions);
        }
      };
    return DataxServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataxServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public void run(com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest request,
        io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public void stop(com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest request,
        io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRunMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest,
                com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse>(
                  this, METHODID_RUN)))
          .addMethod(
            getStopMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest,
                com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse>(
                  this, METHODID_STOP)))
          .build();
    }
  }

  /**
   */
  public static final class DataxServiceStub extends io.grpc.stub.AbstractAsyncStub<DataxServiceStub> {
    private DataxServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataxServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataxServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public void run(com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest request,
        io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public void stop(com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest request,
        io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataxServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataxServiceBlockingStub> {
    private DataxServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataxServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataxServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public java.util.Iterator<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse> run(
        com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse stop(com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataxServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataxServiceFutureStub> {
    private DataxServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataxServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataxServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * 运行Datax任务
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse> stop(
        com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN = 0;
  private static final int METHODID_STOP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataxServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataxServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN:
          serviceImpl.run((com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunRequest) request,
              (io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.RunResponse>) responseObserver);
          break;
        case METHODID_STOP:
          serviceImpl.stop((com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopRequest) request,
              (io.grpc.stub.StreamObserver<com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.StopResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataxServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataxService");
    }
  }

  private static final class DataxServiceFileDescriptorSupplier
      extends DataxServiceBaseDescriptorSupplier {
    DataxServiceFileDescriptorSupplier() {}
  }

  private static final class DataxServiceMethodDescriptorSupplier
      extends DataxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataxServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataxServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataxServiceFileDescriptorSupplier())
              .addMethod(getRunMethod())
              .addMethod(getStopMethod())
              .build();
        }
      }
    }
    return result;
  }
}
