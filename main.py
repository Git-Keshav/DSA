# class Student:
#     def info(self, RollNo, Name):
#         self.Rollno = RollNo
#         self.Name = Name

#     def display(self):
#         print(self.Rollno)
#         print(self.Name)

# a = Student()

# inserInfo = a.info(input("Enter Roll: "), input("Enter Name: "))
# print(a.display())

# Reversing a String
# class main:
#     def rev(self, str):
#         self.str1 = str
#         self.rev = self.str1[::-1]

#     def display(self):
#         print(self.rev)

# reversestr = main()
# print(reversestr.rev("12345"))

# Linear Search
class Searching:
    def linearSearch(self, arr, key):
        self.arr = arr
        self.key = key

        n = len(self.arr)
        for i in range(n):
            if self.arr[i] == self.key:
                print("Element found at index, ", i)
        else:
            print("Element not found or not present")
            
b = Searching()
b.arr = int(input("Enter elements: "))
b.key = int(input("Enter key: "))
