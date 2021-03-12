package main

import (
	"fmt"
)

func main()  {
	fmt.Printf("sfasf")
	var num int =10
	print(num)
	println(num)
	num = 22
	println(num)
	//无符号 8 位整型 (0 到 255)
	var num2 uint8 = 225
	println(num2)
	//无符号 16 位整型 (0 到 65535)
	var num3 uint16 = 990
	println(num3)
	//无符号 32 位整型 (0 到 4294967295)
	var num4 uint32 = 4294967294
	println(num4)

	var num5 float32 = 23442.343432
	println(num5)
	//32 位实数和虚数
	var num6 complex64  = 1231313131.132132456
	println(num6)
	//类似 uint8  0-255
	var num7 byte = 255
	println(num7)
	//类似 int32
	var num8 rune = 2147483647
	println(num8)
	// int = uint 32 或 64 位
	var num9 uint = 123456789123
	println(num9)
	//	无符号整型，用于存放一个指针 uintptr
	var num10 bool = true
	println(num10)
	var num11 string = "sdfasdf"
	println(num11)




	       
}
