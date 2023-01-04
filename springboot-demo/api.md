# test0 (3)

## 1.test1

**路径**: POST /test

**请求参数**


**响应参数**

*Body:*

| 名称 | 必选 | 类型 | 默认值 | 描述 |
| --- | --- | --- | --- | --- |
|  | 否 | string |  | String |

## 2.test2

**路径**: GET /users/{id}

**请求参数**

*Path:*

| 名称 | 必选 | 类型 | 默认值 | 描述 |
| --- | --- | --- | --- | --- |
| id | 是 | integer |  |  |


**响应参数**

*Body:*

| 名称 | 必选 | 类型 | 默认值 | 描述 |
| --- | --- | --- | --- | --- |
| id | 是 | integer |  | 用户id |
| name | 否 | string |  |  [长度: 0~123] |
| status | 否 | string |  |  |
| hand | 否 | object[] |  |  |
| &nbsp;&nbsp;└ finger | 否 | string |  |  |

## 3.lkadjslfk

**路径**: POST /users/{id}

**请求参数**

*Body:*

| 名称 | 必选 | 类型 | 默认值 | 描述 |
| --- | --- | --- | --- | --- |
| id | 是 | integer |  | 用户id |
| name | 否 | string |  |  [长度: 0~123] |
| status | 否 | string |  |  |
| hand | 否 | object[] |  |  |
| &nbsp;&nbsp;└ finger | 否 | string |  |  |

**响应参数**


