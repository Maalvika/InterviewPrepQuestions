def contigous_calc(n, a):
    if all(i<0 for i in a) == True:
        return max(a)
    sum_val = []
    min_val = []
    sum_val.append(a[0])
    min_val.append(min(0,a[0]))
    for i in range(1,n):
        sum_val.append(sum_val[i-1]+a[i])
        min_val.append(min(min_val[i-1],sum_val[i]))
    diff_val = [a_i-b_i for a_i,b_i in zip(sum_val,min_val)]
    return max(diff_val)

def non_contigous(n, a):
    sum_val = []
    for i in a:
        if(i>0):
            sum_val.append(i)
    
    if len(sum_val) == 0:
        return max(a)
    return sum(sum_val)
            
    
tc = int(raw_input())
for i in range(tc):
    n = int(raw_input())
    a =  map(int, raw_input().strip().split(' '))
    print contigous_calc(n,a), non_contigous(n,a)