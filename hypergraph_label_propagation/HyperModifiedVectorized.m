function[S] = HyperModifiedVectorized(H, D_e, D_v, W)

[m, n] = size(H);
%tmp = zeros(m, n);
tmp = sparse([],[],[],m,n);
t_3 = toc;
for i = 1 : n
    if D_e(i) ~= 0
        
        tmp(:, i) = H(:, i) * sqrt(W(i)) / sqrt(D_e(i));
        
    end
end
t_4 = toc-t_3

S = tmp * tmp';

t_5 = toc - t_4
nnz(S)
[S_i, S_j, ~] = find(S);
size(S_i)
size(S_j)
t_6 = toc - t_5 ;
count = 0;
S1 = S;
t_7 = toc - t_6
S((S_j-1)*size(S,1) + S_i) = S((S_j-1)*size(S,1) + S_i) ./sqrt(D_v(S_i)) ./sqrt(D_v(S_j));
t_8 = toc - t_7
%{
for i = 1: size(S_i,1)
    
    if S(S_i(i), S_j(i)) ~=0            
        count = count +1;
        S(S_i(i), S_j(i)) = S(S_i(i), S_j(i)) / sqrt(D_v(S_i(i)))...
                                                / sqrt(D_v(S_j(i)));            
    end        
    
end
%}

%S
count
toc 
end

