package com.z5.zcms.util;
/* Serializable.java
*
* Author:       Ma Bingyao <andot@ujn.edu.cn>
* Copyright:    CoolCode.CN
* Version:      2.1
* LastModified: 2006-08-09
* This library is free.  You can redistribute it and/or modify it.
* http://www.coolcode.cn/?p=202
*/

interface Serializable {
    byte[] serialize();
    void unserialize(byte[] ss);
}