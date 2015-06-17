function [] = hyperagent_newest(K,alpha, delta, maxItr)

% Hyper-incidence matrix H (m # Vertices X n # Edges)
H_Idx = load('values1.txt');
H = sparse(H_Idx(:,2)+1, H_Idx(:,1)+1, ones(size(H_Idx,1),1));
n_original = size(unique(H_Idx(:,1)),1); % # Hyper Edges 
m_original = size(unique(H_Idx(:,2)),1); % # Vertices 
n_original
m_original

% Weight (Kapoor et al. 2013)
W_mat = load('values3.txt'); 
% Semi-supervised learning by HyperPrior
[F] = HyperModifiedVectorized(H, K, alpha, W_mat, delta, maxItr);
[F] = OptimizeF(F,Y,2,.001,50);
end