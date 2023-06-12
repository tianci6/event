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
export const list = (params) => {
    return request({
        url: `/eventi/material/list`,
        method: "get",
        params: params
    });
};
export const add = (params) => {
    return request({
        url: `/eventi/material/add`,
        method: "post",
        data: params
    });
};
export const session = (params) => {
    return request({
        url: `/eventi/users/session`,
        method: "get",
        params: params
    });
};
export const resetPass = (params) => {
    return request({
        url: `/eventi/users/resetPass`,
        method: "get",
        params: params
    });
};
export const selectMyMaterial = (params) => {
    return request({
        url: `/eventi/material/selectMyMaterial`,
        method: "get",
        params: params
    });
};
export const collectMaterial = (params) => {
    return request({
        url: `/eventi/userMaterial/collectMaterial`,
        method: "get",
        params: params
    });
};
export const selectMyCollect = (params) => {
    return request({
        url: `/eventi/userMaterial/selectMyCollect`,
        method: "get",
        params: params
    });
};

export const checkCollect = (params) => {
    return request({
        url: `/eventi/userMaterial/checkCollect`,
        method: "get",
        params: params
    });
};
export const adds = (params) => {
    return request({
        url: `/eventi//materialEvaluate/add`,
        method: "post",
        data: params
    });
};










