import {request} from '../request'

export function api_login(username, password) {
  return request({
    url: '/ums/admin/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function api_logout() {
  return request({
    url: '/admin/logout',
    method: 'post'
  })
}

export function api_test() {
  return request({
    url: '/pms/products',
    method: 'post'
  })
}
