package org.zstack.storage.ceph.primary

import org.zstack.header.errorcode.ErrorCode
import org.zstack.storage.ceph.primary.CephPrimaryStoragePoolInventory

doc {

	title "更新 Ceph 主存储 Pool 存储池 "

	ref {
		name "error"
		path "org.zstack.storage.ceph.primary.APIUpdateCephPrimaryStoragePoolEvent.error"
		desc "错误码，若不为null，则表示操作失败, 操作成功时该字段为null",false
		type "ErrorCode"
		since "0.6"
		clz ErrorCode.class
	}
	ref {
		name "inventory"
		path "org.zstack.storage.ceph.primary.APIUpdateCephPrimaryStoragePoolEvent.inventory"
		desc "null"
		type "CephPrimaryStoragePoolInventory"
		since "0.6"
		clz CephPrimaryStoragePoolInventory.class
	}
}
