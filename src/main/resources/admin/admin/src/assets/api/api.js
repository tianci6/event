import request from "./axios";
export const login = (params) => {
    return request({
        url: `/eventi/jumin/login`,
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
        url: `/eventi/jumin/session`,
        method: "get",
        params: params
    });
};
export const resetPass = (params) => {
    return request({
        url: `/eventi/jumin/resetPass`,
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
        url: `/eventi/materialEvaluate/add`,
        method: "post",
        data: params
    });
};
export const page = (params) => {
    return request({
        url: `/eventi/materialEvaluate/page`,
        method: "get",
        params: params
    });
};
export const userMaterial = (params) => {
    return request({
        url: `/eventi/userMaterial/page`,
        method: "get",
        params: params
    });
};
export const ddusers = (params) => {
    return request({
        url: `/eventi/jumin/page`,
        method: "get",
        params: params
    });
};
export const deletes = (params) => {
    return request({
        url: `/eventi/jumin/delete`,
        method: "post",
        data: params
    });
};
export const materialdel = (params) => {
    return request({
        url: `/eventi/material/delete`,
        method: "post",
        data: params
    });
};
export const config = (params) => {
    return request({
        url: `/eventi/config/page`,
        method: "post",
        data: params
    });
};
export const materialEvaluate = (params) => {
    return request({
        url: `/eventi/materialEvaluate/delete`,
        method: "post",
        data: params
    });
};
export const registers = (params) => {
    return request({
        url: `/eventi/jumin/register`,
        method: "post",
        data: params
    });
};
export const updates = (params) => {
    return request({
        url: `/eventi/jumin/update`,
        method: "post",
        data: params
    });
};






















