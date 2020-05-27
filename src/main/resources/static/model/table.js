class TimeNow extends React.Component{
    constructor(){
        super();
        this.state = {
            time: ''
        }
    }
    componentDidMount = () =>{
        setInterval(()=>{
            var time = new Date().toLocaleString();
            this.setState({
                time
            });
        }, 1000);
    }
    render = () => {
        const {time} = this.state;
        return <div>时间：{time}</div>
    }
}
class MessageBox extends React.Component{
    constructor(){
        super()
        this.state = {
            list : []
        }
    }
    logout = ()=>{
        fetch('/api/v1/logout',{
            method:'post',
            headers:{
                'Accept':'application/json,text/plain,*/*',/* 格式限制：json、文本、其他格式 */
                'Content-Type':'application/x-www-form-urlencoded'/* 请求内容类型 */
            },
            body:``
        }).then((response)=>{
            return response.json()
        }).then((data)=>{
            if (data.code === 200){
                window.location.href='/login';
            }
        }).catch(function(error){
            console.log(error)
        })
    }
    componentDidMount() {
        fetch('/api/v1/log',{
            method:'get',
            headers:{
                'Accept':'application/json,text/plain,*/*',/* 格式限制：json、文本、其他格式 */
                'Content-Type':'application/x-www-form-urlencoded'/* 请求内容类型 */
            }
        }).then((response)=>{
            return response.json()
        }).then((data)=>{
            this.setState({
                list: data.data
            })
        }).catch(function(error){
            console.log(error)
        })
    }
    render = ()=>{
        return (
            <div>
                <h1>我的账号日志</h1>
                {this.state.list.map((item,i) =>
                    <div key={i}>
                        <span>{item.ulLoginMsg} --- {item.ulLoginIp} --- {item.creTime}</span>
                    </div>
                )}
                <antd.Button onClick={this.logout} type="primary">退出登录</antd.Button>
                <TimeNow />
            </div> )
    }
}
ReactDOM.render( <MessageBox/>,
    document.getElementById('table'),
)
