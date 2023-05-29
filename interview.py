#using binary search

def search(arr):
    l=0
    r=len(arr)-1
    while(r>l+1):
        mid=l+(l-r)//2
        if(abs(arr[l]-l) >1):
            r=mid
        elif(abs(arr[r]) >1):
            l=mid
    return (arr[r]-1)