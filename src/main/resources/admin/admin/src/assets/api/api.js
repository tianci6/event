import request from "./axios";
export const login = (params) => {
    return request({
        url: `/eventi/users/login`,
        method: "post",
        params: params
    });
};
export const register = (params) => {
    return request({
        url: `/eventi/users/register`,
        method: "post",
        data: params
    });
};
export const upload = (params) => {
    return request({
        url: `/eventi/file/upload`,
        method: "post",
        data: params
    });
};
export const add = (params) => {
    return request({
        url: `/eventi/material/add`,
        method: "post",
        data: params
    });
};


