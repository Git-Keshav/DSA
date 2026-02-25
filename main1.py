class Students:
    def __init__(self, name, age, roll_no):
        self.name = name
        self.age = age
        self.roll_no = roll_no
        
    def display(self):
        print(self.name, self.age, self.roll_no)

student1 = Students("Alice", 20, 101)
student2 = Students("Bob", 21, 102)
student3 = Students("Charlie", 22, 103)

student1.display()
student2.display()
student3.display()

