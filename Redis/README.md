
## redis数据库

简介： redis属于非关系型数据库,数据存储在内存中,存储方式为键值对 数据类型有 String list hashmap set sortedset 五种类型。

### 数据类型

1. 字符串

  ```
  最基本的存储类型 语法如下
  set key value : 存值，若有则覆盖
  get key       ： 取值,若无则返回null，若不是String类型则返回错误信息
  getset key    : 先取值打印,再存值
  incr key      : 将key自增一，若不存在默认为1.若存在String类型，变为1
  decr key      : 自减一
  append key value：涉及到字符串的拼装
  incrby key increment/decrby key decrement：+= /-=
  ```

2. List

      **List类型是按照插入顺序排序的字符串链表。和数据结构中的普通链表	一样，我们可以在其头部(left)和尾部(right)添加新的元素。**

        ```
        语法如下:
        lpush key value1 value2  ： 在list前面插入所有的values,如果key不存在，重新建造，完成后返回元素当前个数
        rpush key value1 value2  ： 在list的尾部添加元素
        lrange key start end     ： 测量list的长度 例：lrange p 0 -1 注意：索引位第一个为 0
        lpushx/rpushx key value  ： 存在Key的时候,添加左右值
        lpop/rpop key            :  弹出左右一个元素
        llen key                 :  测量长度
        rpoplpush A B            :  把A的尾部加入B的前面
        lset key index Value     :  设置key的index位的值为value
        linsert key after a b    :  设置list的a后插入b
        ```


比较重要就是这2种数据类型

### 对key的操作

```
keys */? 作为通配符来匹配

del keys 删除数据

exits 判断是否存在key名 返回boolean

rename key newkey 改名

expire key time 设置过期时间 -2为失效


```

### redis的持久化操作
  redis包括2种持久化工具
1. RDP 默认的持久化行为 在redis中一个key被更新后 就会自动将数据更新到磁盘上，时间在redis-conf文件上查看
2. AOF 需要开启，同时AOF存储的不是具体数据而是对数据的一些操作 变相的记录了修改的值 相比于RDP方法 数据保存的完整性要优 但比较缓慢

具体配置见pdf


### redis的事务操作
与mysql 有所差异，这里的事务更倾向于一种批量处理

- multi 开启事务

- exec  提交事务

- discard 事务回滚



# 对redis的配置与如何配置持久化 包括对set等数据类型的使用 均在pdf中
# Jredis的操作在Java项目中
