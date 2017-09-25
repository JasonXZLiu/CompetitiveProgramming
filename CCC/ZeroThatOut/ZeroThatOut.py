list_a = [0]
total = 0
i = 0
num = int(input())

for m in range(1,num+1):
    n = int(input())
    if n == 0:
        total -= list_a[i]
        list_a.pop(i)
        i -= 1
    else:
        list_a.append(n)
        total += int(n)
        i += 1

print(total)