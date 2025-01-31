/******************************************************************************
 *
 *   Copyright (C) 2011  Intel Corporation. All rights reserved.
 *
 *   SPDX-License-Identifier: GPL-2.0-only
 *
 *****************************************************************************/

#include <linux/module.h>

static int __init hello_init(void)
{
    int val = *(int *)0;
	pr_info("Hello World!\n");
    
	return val;
}

static void __exit hello_exit(void)
{
	pr_info("Goodbye Cruel World!\n");
}

module_init(hello_init);
module_exit(hello_exit);
MODULE_LICENSE("GPL");
