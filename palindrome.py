class Palindrome:
    def isPlaindrome(self, str):
        self.str = str
        i = 0
        j = len(self.str)-1
        
        while i<j:
            if self.str[i].lower() == self.str[j].lower():
                i=i+1
                j=j-1
            elif self.str[i].isalnum() == False:
                i=i+1
                
            elif self.str[j].isalnum() == False:
                j=j-1
            else:
                return False
                
        return True
        
Palin = Palindrome()
print(Palin.isPlaindrome("A man, a plan, a canal: Panama"))