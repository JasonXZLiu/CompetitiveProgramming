class Solution {
    public int largestComponentSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        List<List<Integer>> primeFacs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            primeFacs.add(new ArrayList<>());
            int div = 2, num = A[i];
            
            while (div * div <= num) {
                if (num % div == 0) {
                    while (num % div == 0) {
                        num /= div;
                    }
                    primeFacs.get(i).add(div);
                }
                div ++;
            }
            
            if (num > 1 || primeFacs.get(i).isEmpty())
                primeFacs.get(i).add(num);
        }
        
        Set<Integer> primes = new HashSet<>();
        for (List<Integer> facs : primeFacs)
            for (int fac : facs)
                primes.add(fac);
        
        int[] primeIndex = new int[primes.size()];
        int k = 0;
        for (int prime : primes)
            primeIndex[k++] = prime;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < primeIndex.length; i++)
            map.put(primeIndex[i], i);
        
        DSU dsu = new DSU(primeIndex.length);
        for (List<Integer> facs : primeFacs)
            for (int fac : facs)
                dsu.union(map.get(facs.get(0)), map.get(fac));

        int[] counts = new int[primeIndex.length];
        for (List<Integer> facs : primeFacs)
            counts[dsu.find(map.get(facs.get(0)))] ++;
        
        int ans = Integer.MIN_VALUE;
        for (int count : counts) {
            ans = Math.max(count, ans);
        }
        
        return ans;
    }
    
    class DSU {
        int[] parents;
        
        public DSU(int N) {
            parents = new int[N];
            for (int i = 0; i < N; i++) parents[i] = i;
        }
        
        public int find(int p) {
            if (parents[p] != p) return find(parents[p]);
            else return p;
        }
        
        public void union(int p, int q) {
            parents[find(p)] = find(q);
        }
    }
}