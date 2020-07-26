import axios from 'axios'

export function request (config) {
  const instance = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 15000
  })

  //请求拦截
  instance.interceptors.request.use(config => {
    const token = window.sessionStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = token
    }
    return config
  }, err => {
    console.log(err);
  })

  // 响应拦截
  instance.interceptors.response.use(res => {
    return res.data
  }, err => {
    console.log(err);
  })

  return instance(config)
}
