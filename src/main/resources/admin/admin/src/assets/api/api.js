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
