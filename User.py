class User:
    def __init__(self, name: str, password: str):
        self.name = name
        self.password = password
        print("User.__init__")

    def __str__(self):
        return f'User(name={self.name}, password={self.password})12312312'

    def __repr__(self):
        return self.__str__()

    def __eq__(self, other):
        return self.name == other.name and self.password == other.password

    def __hash__(self):
        return hash(self.name) + hash(self.password)

    def __del__(self):
        print("User.__del__")

user = User("admin", "123456")
print(user)