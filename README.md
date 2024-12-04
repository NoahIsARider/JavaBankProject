# JavaBankProject

## 实验1 - 熟悉Java运行环境

### 实验题

1. **环境变量配置**（5分）
   - 环境变量设置并截图（3分）
   - `java -version`并截图（2分）

2. **Step 1文件夹**（14分）
   - Account类实现代码或代码截图（10分）
   - 使用`javac`编译`.java`文件并截图（2分）
   - 运行`TestBanking`文件并截图（2分）

3. **Step 2文件夹**（12分）
   - Customer类实现代码或代码截图（10分）
   - 运行`TestingBanking`文件并截图（2分）

4. **Step 3文件夹**（22分）
   - `deposit`方法实现代码或代码截图（10分）
   - `withdraw`方法实现代码或代码截图（10分）
   - 运行`TestBanking`文件并截图（2分）

5. **Step 4文件夹**（12分）
   - Bank类实现代码或代码截图（10分）
   - 运行`TestBanking`文件并截图（2分）

### 思考题

1. 假设在`TestBanking`类中引用了`Account`类和`Customer`类，在编辑了三个类的源文件后，仅编译`TestBanking.java`源文件同时也生成了其他类的类文件，为什么？进一步归纳，当编译器需要某个类的信息时，如何搜索定义该类的源文件或类文件？

2. 假设已定义了`Banking.Customer`类和`Banking.Account`类，并且`Customer`类中引用了`Account`类，若直接在该类所在目录（/banking子目录下）运行`Javac customer.java`会出错，请分析出错原因。

3. 描述`-classpath`类路径的作用，思考JDK的编译器和虚拟机是如何定位到所需的类文件的？归纳编译器搜索类的顺序以及JVM搜索类的顺序。

## 实验2 - 面向对象的编程技术

### 实验题

1. **Step 5文件夹**
   - Account类实现代码或代码截图（10分）
   - SavingAccount类实现代码或代码截图（10分）
   - CheckingAccount类实现代码或代码截图（10分）
   - TestBanking类修改代码或代码截图，运行TestBanking文件并截图（2分）

2. **Step 6-PR1文件夹**
   - Customer类实现代码或代码截图（10分）
   - 运行TestBanking文件并截图（1分）

3. **Step 6-PR2 文件夹**
   - Bank类实现代码或代码截图（10分）
   - CustomerReport类实现代码或代码截图（10分）
   - 运行TestBanking文件并截图（2分）

### 思考题

1. 思考如何对`ArrayList`定义的`Account`集合排序，按照账户的余额由小到大排列？请描述实现思想或关键语句。

2. 归纳单例模式的设计原理，思考为什么属性和方法为static？构造函数为private？

## 实验3 - 接口实现与异常处理

### 实验题

1. **Step 6文件夹**
   - sortCustomers方法实现代码或代码截图（10分）
   - searchCustomers方法实现代码或代码截图（5分）
   - compareTo方法实现代码或代码截图（10分）
   - CustomerReport类实现代码或代码截图（5分）
   - 运行TestBanking文件并截图（5分）

2. **Step 7文件夹**
   - OverdraftException类实现代码或代码截图（15分）
   - Account类的withdraw方法实现代码或代码截图（5分）
   - CheckingAccount类的withdraw方法实现代码或代码截图（5分）
   - 运行TestBanking文件并截图（5分）

### 思考题

1. 该程序编译后生成几个class文件？

2. 创建一个类Bird（鸟），给出其声音特征，并在主类中创建一个Bird类的实例，输出其特征。

3. 如何编写抽象类代替程序中的接口，实现程序同样的功能。试比较它们的不同。

## 实验4 - GUI程序设计与I/O文件处理

### 实验题

1. 创建一个java工程，导入AddressBook.java 和FixedLengthStringIO.java文件，编译运行，运行结果截图（10分）

2. **Step 8**
   - 新建banking.DAO 包，在该包中导入FixedLengthStringIO.java、新建CustomerDAO.java。CustomerDAO类封装了Customer文件访问的所有方法。CustomerDAO类实现代码或代码截图。（20分）
   - 修改Bank类，调用CustomerDAO类的方法，使其支持从文件读取客户或保存客户至文件。Bank类实现代码或代码截图。（20分）
   - 新建banking.UI 包，新建MainWindow.java, 调用Bank类的方法，处理界面组件的显示及相应按钮事件。MainWindow类实现代码或代码截图。（20分）
   - 运行MainWindow文件，增加客户，删除客户，搜索客户，客户排序的界面截图。（20分）
     - 增加客户：
     - 删除客户：
     - 搜索客户：
     - 客户排序（用姓氏排）：
