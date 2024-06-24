import axios from 'axios'

const request = axios.create({
    baseURL: 'http://localhost:8080',
    // timeout: 5000  超时限制
})
export default request