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
            name: '',
            pwd: '',
            phone: '',
            email: ''
        }
    }
    handleChange(e){
        this.setState({
            name: e.target.value
        })
    }
    handleChange1(e){
        this.setState({
            pwd: e.target.value
        })
    }
    handleChange2(e){
        this.setState({
            phone: e.target.value
        })
    }
    handleChange3(e){
        this.setState({
            email: e.target.value
        })
    }
    reg = ()=>{
        fetch('/api/v1/reg',{
            method:'post',
            headers:{
                'Accept':'application/json,text/plain,*/*',/* 格式限制：json、文本、其他格式 */
                'Content-Type':'application/x-www-form-urlencoded'/* 请求内容类型 */
            },
            body:`usName=${this.state.name}&usPassword=${this.state.pwd}&usCellPhone=${this.state.phone}&usEmail=${this.state.email}`
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
    onlogin = ()=>{
        window.location.href='/login';
    }
    render = ()=>{
        return (
            <div>
                <h1>百格面试</h1>
                <antd.Input value={this.state.name} onChange={this.handleChange.bind(this)} size="large" placeholder="昵称" />
                <antd.Input value={this.state.phone} onChange={this.handleChange2.bind(this)} size="large" placeholder="手机号" />
                <antd.Input value={this.state.email} onChange={this.handleChange3.bind(this)} size="large" placeholder="邮箱" />
                <antd.Input type="password" value={this.state.pwd} onChange={this.handleChange1.bind(this)} size="large" placeholder="密码" />
                <antd.Button onClick={this.reg} type="primary">注册</antd.Button>
                <antd.Button onClick={this.onlogin} type="link">已有账号，去登录</antd.Button>
                <TimeNow />
            </div> )
    }
}

ReactDOM.render( <MessageBox/>,
    document.getElementById('formreg'),
)
