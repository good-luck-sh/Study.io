import http from '../http';

export default {
  list(criteria) {
    return http.get('/book', {
      params: criteria
    });
  },
  save(book) {
    return http.post('/book', book);
  },
  detail(no) {
    return http.get('/book/' + no);
  },
  remove(no) {
    return http.delete('/book/' + no);
  },
  update(no, book) {
    return http.put('/book/' + no, book);
  }
}