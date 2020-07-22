import Vue from 'vue'
import 'element-ui/lib/theme-chalk/index.css'

import { Form, FormItem, Button, ButtonGroup, Input, Checkbox, Card, Avatar, Dropdown, DropdownItem, DropdownMenu, Menu, MenuItem, MenuItemGroup, Submenu, Container, Aside, Header, Main, Row, Col, Breadcrumb, BreadcrumbItem, Cascader, Select, Option, Table, TableColumn, Image, Switch, Dialog, Pagination, Message, MessageBox, Loading, Notification } from 'element-ui'

Vue.use(Form)
Vue.use(FormItem)

Vue.use(Button)
Vue.use(ButtonGroup)

Vue.use(Input)

Vue.use(Checkbox)

Vue.use(Card)

Vue.use(Avatar)

Vue.use(Dropdown)
Vue.use(DropdownItem)
Vue.use(DropdownMenu)

Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Submenu)

Vue.use(Container)
Vue.use(Aside)
Vue.use(Header)
Vue.use(Main)

Vue.use(Row)
Vue.use(Col)

Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)

Vue.use(Cascader)

Vue.use(Select)
Vue.use(Option)

Vue.use(Table)
Vue.use(TableColumn)

Vue.use(Image)

Vue.use(Switch)

Vue.use(Dialog)

Vue.use(Pagination)
Vue.prototype.$loading = Loading.service
Vue.prototype.$msgbox = MessageBox
Vue.prototype.$alert = MessageBox.alert
Vue.prototype.$confirm = MessageBox.confirm
Vue.prototype.$prompt = MessageBox.prompt
Vue.prototype.$notify = Notification
Vue.prototype.$message = Message
