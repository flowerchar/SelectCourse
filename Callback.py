class ReactiveData:
    def __init__(self, initial_value):
        self._value = initial_value
        self._callbacks = []

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, new_value):
        self._value = new_value
        self._notify_callbacks()

    def add_callback(self, callback):
        self._callbacks.append(callback)

    def _notify_callbacks(self):
        for callback in self._callbacks:
            callback(self._value)

# 创建一个 ReactiveData 实例
data = ReactiveData("Hello")

# 定义一个回调函数，在数据发生变化时打印新值
def callback(value):
    print("Value changed:这里相当于表现层的变化", value)

# 将回调函数添加到 ReactiveData 实例中
data.add_callback(callback)

# 模拟数据双向绑定，通过命令行实现交互
while True:
    print("Current value:当前UI层是", data.value)
    new_value = input("Enter a new value (press 'q' to quit): 这里相当于在前端具有v-model中的input事件，实现了数据的双向绑定\n")
    if new_value.lower() == 'q':
        break
    data.value = new_value
