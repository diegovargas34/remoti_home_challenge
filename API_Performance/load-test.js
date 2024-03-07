import http from 'k6/http';
import {sleep , check} from 'k6';

let randomID = Math.floor((Math.random() * 20) + 1);

export const options = {

    stages: [
        {duration: '30s', target: 200},
        {duration: '5m', target: 200},
        {duration: '30s', target: 0},
    ],
    thresholds: {
        http_req_duration: ['p(99) < 100'],
    }
};

export default () => {

    const res = http.get(`https://petstore3.swagger.io/api/v3/pet/${randomID}`);
    check(res, { '200': (r) => r.status === 200});
    sleep(1);

};