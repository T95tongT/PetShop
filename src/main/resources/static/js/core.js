/**
 * Created by Administrator on 2017/6/28 0028.
 */
function parseAddress(address){
    var json={};
    var index=address.lastIndexOf("?");
    var str=address.substring(index+1,address.length);
    var s=str.split("&")[0];
    var s1=str.split("&")[1];
    json={"query":s.split("=")[1],"page":s1.split("=")[1]};
    return json;
}

