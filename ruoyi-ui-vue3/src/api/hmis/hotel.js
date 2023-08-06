import request from '@/utils/request'

// 查询酒店详情列列表
export function listHotel(query) {
  return request({
    url: '/hmis/hotel/list',
    method: 'get',
    params: query
  })
}

// 查询酒店详情列详细
export function getHotel(hotelId) {
  return request({
    url: '/hmis/hotel/' + hotelId,
    method: 'get'
  })
}

// 新增酒店详情列
export function addHotel(data) {
  return request({
    url: '/hmis/hotel',
    method: 'post',
    data: data
  })
}

// 修改酒店详情列
export function updateHotel(data) {
  return request({
    url: '/hmis/hotel',
    method: 'put',
    data: data
  })
}

// 删除酒店详情列
export function delHotel(hotelId) {
  return request({
    url: '/hmis/hotel/' + hotelId,
    method: 'delete'
  })
}
