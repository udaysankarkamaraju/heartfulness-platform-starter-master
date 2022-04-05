package org.heartfulness.starter;

import org.heartfulness.starter.domain.exception.InvalidRequestException;
import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.domain.service.TaskManagerService;
import org.heartfulness.starter.domain.service.VisitorTaskService;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.ApproveTask;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.CreateNewTaskPost;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.SupervisorList;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskAcceptRejectPostRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskManagerDashboard;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskManagerGetAllTaskList;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskManagerGetTaskResponse;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskManagerTaskPostResponse;
import org.heartfulness.starter.interfaces.grpc.TaskManagerServiceGrpc.TaskManagerServiceImplBase;
import org.heartfulness.starter.interfaces.internal.assembler.TaskManagerGrpcAssembler;
import org.heartfulness.starter.interfaces.internal.assembler.VisitorTaskGrpcAssembler;
import org.heartfulness.unifiedplatform.infrastructure.utils.auth.grpc.AuthenticationServerInterceptor;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.Empty;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

@GRpcService(interceptors = {AuthenticationServerInterceptor.class})
public class TaskManagerGRPCServiceImpl extends TaskManagerServiceImplBase {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TaskManagerGRPCServiceImpl.class);

    @Autowired
    TaskManagerService taskManagerService;
    
    @Override
    public void getDashBoardService(Empty request, StreamObserver<TaskManagerDashboard> responseObserver) {
        // TODO Auto-generated method stub
        super.getDashBoardService(request, responseObserver);
    }

    @Override
    public void getRequestedTasksService(Empty request, StreamObserver<TaskManagerGetTaskResponse> responseObserver) {
        // TODO Auto-generated method stub
        super.getRequestedTasksService(request, responseObserver);
    }

    @Override
    public void getSupervisorsListService(Empty request, StreamObserver<SupervisorList> responseObserver) {
        // TODO Auto-generated method stub
        super.getSupervisorsListService(request, responseObserver);
    }

    @Override
    public void postAcceptOrRejectTasksService(TaskAcceptRejectPostRequest request,
            StreamObserver<Empty> responseObserver) {
        // TODO Auto-generated method stub
        super.postAcceptOrRejectTasksService(request, responseObserver);
    }

    @Override
    public void getAllTasksService(Empty request, StreamObserver<TaskManagerGetAllTaskList> responseObserver) {
        // TODO Auto-generated method stub
        super.getAllTasksService(request, responseObserver);
    }

    @Override
    public void postCreateNewTaskService(CreateNewTaskPost request,
            StreamObserver<TaskManagerTaskPostResponse> responseObserver) {
        try {
            VisitorTask visitorTask = taskManagerService.createNewTask(TaskManagerGrpcAssembler.fromGrpc(request));
            responseObserver.onNext(TaskManagerGrpcAssembler.toGrpc(visitorTask));
            responseObserver.onCompleted();
        } catch (InvalidRequestException ex) {
            log.error("Error occurred while adding new task", ex);
            responseObserver.onError(ex.toGRPCException());
            return;
        } catch (Exception e) {
            log.error("Error occurred while adding new task", e);
            responseObserver.onError(Status.INTERNAL.asRuntimeException());
        }
    }

    @Override
    public void postApproveTasksService(ApproveTask request, StreamObserver<Empty> responseObserver) {
        // TODO Auto-generated method stub
        super.postApproveTasksService(request, responseObserver);
    }

    
}
