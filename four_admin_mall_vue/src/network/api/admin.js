import { request } from '../request'

export function api_logout () {
  return request({
    url: '/admin/logout',
    method: 'post'
  })
}
