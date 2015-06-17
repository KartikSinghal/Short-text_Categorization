function[F,num_iter] = OptimizeF(S, Y, alpha, delta, maxItr)

%nnz(S)
%size(find(S==Inf))
%nnz(Y)
%size(find(Y==Inf))
F = Y;
num_iter=0;
for i = 1 : maxItr
    %tic;
    F_old = F;
    
    F = alpha * S * F + (1 - alpha) * Y;
    %max(abs(F - F_old))
    if max(abs(F - F_old)) < delta
        %disp('Iterations taken in diffusion process:');
        num_iter = i;
        break
    end
    %toc 
end
%disp('Total time taken in diffusion process:');

if i == maxItr
    disp('OptimizeF didn''t converge!')
end
end