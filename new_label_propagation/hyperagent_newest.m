% alpha: is the label diffusion parameter between 0 to 1
% delta: is the error convergence to stop diffusion
% maxItr: is the max diffusion loop iterations
function [] = hyperagent_newest()

%========================= DATE PREPERATION ==============================
% Hyper-incidence matrix H (m # Vertices X n # Edges)
H_Idx = load('hedge_tuples.txt');
H = sparse(H_Idx(:,2)+1, H_Idx(:,1)+1, ones(size(H_Idx,1),1));
n_original = size(unique(H_Idx(:,1)),1); % # Hyper Edges 
m_original = size(unique(H_Idx(:,2)),1); % # Vertices 
n_original
m_original

% Weight (Kapoor et al. 2013) (size: n x 1)
W_mat = load('weights.txt'); 

% Category List
fid = fopen('acmmapmiscclear.txt');
auth_count = 1;
categ = cell(m_original,1);
while 1
    author = fgetl(fid);    
    categ{auth_count,1} = author;            
    if ~ischar(author), break, end    
    auth_count = auth_count + 1;
end
fclose(fid);

% Semi-supervised learning by HyperPrior

% NGD
% Average real
%suffix1 = 'Paper';

% NGD
% Average binary
%suffix1 = 'fvectoraverage';

% LCS
% Average binary
suffix1 = 'results_';

alpha = 0.5; maxItr = 5000; delta = 1e-6; K =20; K_orig=10;

Matrix = []; F_matrix = []; idx_label = []; Matrix_orig = [];
for alpha = 0.5 %[0.01 0.1 0.3 0.5 0.7 0.9 0.99]
    %figure;
    for i = [1:5]
        
        % Label : is the vector (size: m x 1) containing the initial vertices
        % similar to which we have to find the vertices.        
%         
%         Average real
%         ngd = load([suffix1 int2str(i) '.txt']);
%         ngd_avg = mean(ngd')';
%         [~, ngd_top_idx] = sort(ngd_avg);
%         idx_label = [idx_label ngd_top_idx(1:10)];
%         label = zeros(1,size(ngd,1));        
%         
%         % Average binary
%         label(ngd_top_idx(1:10))=1;        
%         
%         % Sum real
%         ngd = load([suffix1 int2str(i) '.txt']);
%         ngd_avg = sum(ngd,2);
%         [~, ngd_top_idx] = sort(ngd_avg);
%         idx_label = [idx_label ngd_top_idx(1:10)];
%         label = zeros(1,size(ngd,1));        
%         
%         % Sum binary
%         label(ngd_top_idx(1:10))=1;        
%         
%         % Sum real
%         lcs = load([suffix1 int2str(i) '.txt']);
%         lcs_avg = sum(lcs,2);
%         [~, lcs_top_idx] = sort(lcs_avg, 'descend');
%         idx_label = [idx_label lcs_top_idx(1:10)];
%         label = zeros(1,size(lcs,1));        
%         
%         % Sum binary
%         label(lcs_top_idx(1:K_orig))=1;        
%         
        % Average real
        lcs = load([suffix1 int2str(i) '.txt']);
        lcs_avg = mean(lcs')';
        [~, lcs_top_idx] = sort(lcs_avg, 'descend');
        idx_label = [idx_label lcs_top_idx(1:10)];
        label = zeros(1,size(lcs,1));        
        
        % Average binary
        label(lcs_top_idx(1:K_orig))=1; 


        fprintf('Categories');
        Matrix_orig = [Matrix_orig categ(lcs_top_idx(1:K_orig))];
        
        % F : is the vector (size: m x 1) containing the similarity values for
        % all the vertices w.r.t the initial Label vector above.
        
        % Write code to make Label vector using the top few nodes that you have
        % found similar using the Google Distance, to the keywords from abstract
        % ...............
        
        [F,S] = HyperModifiedVectorized(H, label', delta, alpha, W_mat, maxItr);
        
        %spy(S)
        %plot(F)
        %hold on;
        F_filter=F;
        F_filter(label>0)= -Inf;
        [~, idx_cat] = sort(F_filter,'descend');
        
        %fprintf('New Categories');
        %categ(idx_cat)        
        [a,b]=find(label>0);
        %idx_label = [idx_label b']
        F_matrix = [F_matrix , F_filter(idx_cat(1:K))]
        Matrix = [Matrix categ(idx_cat(1:K))]
    end
    %csvwrite(['Result_' suffix '_' int2str(alpha) '_top_' int2str(K) '.txt'], Matrix);
end

for i = 1:5
    fprintf('Paper %d \n',i);
    fprintf('\t \t \t Initial Categories \t \t \t \t \t \t \n\n');    
    fprintf('\t \t \t%s \t \t \t \t \t \t \n',Matrix_orig{:,i});
    fprintf('\t \t \t --------------------------- \n\n');
    fprintf('\t \t \t New Categories \t \t \t \t \t \t\n\n');
    fprintf('\t \t \t%s \t \t \t \t \t \t \n',Matrix{:,i});
    %Matrix(i:i+K-1, :)
    fprintf('--------------------------- \n');
end

% Pic the index of top K vertices in the F with the heighest score. 
% Print the keywords coresponding to these vertices. This is the list
% of new keywords we need. 
end