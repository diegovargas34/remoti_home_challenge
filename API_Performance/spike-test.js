import http from 'k6/http';
import {sleep , check} from 'k6';

let randomID = Math.floor((Math.random() * 20) + 1);

export const options = {

    stages: [
        {duration: '30s', target: 2000},
        {duration: '2m', target: 2000},
        {duration: '30s', target: 0},
    ],
};

export default () => {

    const res = http.get(`https://petstore3.swagger.io/api/v3/pet/${randomID}`);
    check(res, { '200': (r) => r.status === 200});
    sleep(1);

};