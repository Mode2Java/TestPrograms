first = 0
next = 1
i=2
n=int(input("enter positive number to generate fibonacci series\n"))
print('fibonacci series \n')
print(first)
while(i<=n):
    sum = first + next
    print(sum)
    first=next
    next=sum
    i=i+1

