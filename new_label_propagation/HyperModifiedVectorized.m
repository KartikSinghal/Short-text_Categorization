function[F,S] = HyperModifiedVectorized(H, label, delta, alpha, W, maxItr)

% Initial Labels
Y_0 = label;

D_e = sum(H, 1);
D_v = sum(H, 2);

% optimize F
[F,S] = OptimizeF(H, D_e, D_v, W, Y_0, alpha, delta, maxItr);

function[F,S] = OptimizeF(H, D_e, D_v, W, Y, alpha, delta, maxItr)

[m, n] = size(H);
%tmp = zeros(m, n);
tmp = sparse([],[],[],m,n);

for i = 1 : n
    if D_e(i) ~= 0
        
        tmp(:, i) = H(:, i) * sqrt(W(i)) / sqrt(D_e(i));
        
    end
end
disp('Time taken in tmp:');


S = tmp * tmp';
disp('Time taken in S:');

%nnz(S)
[S_i, S_j, ~] = find(S);
%size(S_i)
%size(S_j)

count = 0;
S1 = S;

S((S_j-1)*size(S,1) + S_i) = S((S_j-1)*size(S,1) + S_i) ./sqrt(D_v(S_i)) ./sqrt(D_v(S_j));

%S
count
disp('Total time taken in S update:');

%}

nnz(S)
size(find(S==Inf))
nnz(Y)
size(find(Y==Inf))
F = Y;
tic;
for i = 1 : maxItr
    F_old = F;
    
    F = alpha * S * F + (1 - alpha) * Y;
    
    if max(abs(F - F_old)) < delta
        disp('Iterations taken in diffusion process:');
        i
        break
    end
end
disp('Total time taken in diffusion process:');
toc

if i == maxItr
    disp('OptimizeF didn''t converge!')
end
