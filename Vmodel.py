import tkinter as tk

class App:
    def __init__(self, master):
        self.master = master

        self.label = tk.Label(master, text="Enter your name:")
        self.label.pack()

        self.entry_var = tk.StringVar()
        self.entry = tk.Entry(master, textvariable=self.entry_var)
        self.entry.pack()

        self.button = tk.Button(master, text="Submit", command=self.submit)
        self.button.pack()

    def submit(self):
        name = self.entry_var.get()
        print("Name submitted:", name)

root = tk.Tk()
app = App(root)
root.mainloop()
