package org.heartfulness.starter;

import java.util.List;

import org.heartfulness.starter.domain.exception.InvalidRequestException;
import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.domain.service.VisitorTaskService;
import org.heartfulness.starter.dto.VisitorTaskDto;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.UserLoginRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.UserOtpVerificationRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.UserOtpVerificationResponse;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskGetRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskGetResponse;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskPostRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskPostResponse;
import org.heartfulness.starter.interfaces.grpc.VisitorServiceGrpc.VisitorServiceImplBase;
import org.heartfulness.starter.interfaces.internal.assembler.VisitorTaskGrpcAssembler;
import org.heartfulness.unifiedplatform.infrastructure.utils.auth.grpc.AuthenticationServerInterceptor;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

@GRpcService(interceptors = {AuthenticationServerInterceptor.class})
public class VisitorTaskGRPCServiceImpl extends VisitorServiceImplBase {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(VisitorTaskGRPCServiceImpl.class);

    @Autowired
    VisitorTaskService visitorTaskService;

	@Override
	public void userLoginService(UserLoginRequest request, StreamObserver<StringValue> responseObserver) {
		// TODO Auto-generated method stub
		super.userLoginService(request, responseObserver);
	}

	@Override
	public void userOtpVerificationService(UserOtpVerificationRequest request,
			StreamObserver<UserOtpVerificationResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.userOtpVerificationService(request, responseObserver);
	}

	@Override
	public void addVisitorTasksService(VisitorTaskPostRequest request,
			StreamObserver<VisitorTaskPostResponse> responseObserver) {
        try {
        	VisitorTask visitorTask = visitorTaskService.add(VisitorTaskGrpcAssembler.fromGrpc(request));
            responseObserver.onNext(VisitorTaskGrpcAssembler.toGrpc(visitorTask));
            responseObserver.onCompleted();
        } catch (InvalidRequestException ex) {
            responseObserver.onError(ex.toGRPCException());
            return;
        } catch (Exception e) {
            log.error("Error occurred while adding visitor task", e);
            responseObserver.onError(Status.INTERNAL.asRuntimeException());
        }
	}

	@Override
	public void getVisitorTasksService(Empty request, StreamObserver<VisitorTaskGetResponse> responseObserver) {

        try {
        	List<VisitorTask> visitorTask = visitorTaskService.getAllTasks();
            responseObserver.onNext(VisitorTaskGrpcAssembler.toGrpc(visitorTask));
            responseObserver.onCompleted();
        } catch (InvalidRequestException ex) {
            responseObserver.onError(ex.toGRPCException());
            return;
        } catch (Exception e) {
            log.error("Error occurred while getting visitor tasks", e);
            responseObserver.onError(Status.INTERNAL.asRuntimeException());
        }//super.getVisitorTasksService(request, responseObserver);
	}

}
