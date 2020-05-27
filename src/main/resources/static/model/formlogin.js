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
            user: '',
            pwd: ''
        }
    }
    handleChange(e){
        this.setState({
            user: e.target.value
        })
    }
    handleChange1(e){
        this.setState({
            pwd: e.target.value
        })
    }
    loginon = ()=>{
        fetch('/api/v1/login',{
            method:'post',
            headers:{
                'Accept':'application/json,text/plain,*/*',/* 格式限制：json、文本、其他格式 */
                'Content-Type':'application/x-www-form-urlencoded'/* 请求内容类型 */
            },
            body:`username=${this.state.user}&pwd=${this.state.pwd}`
        }).then((response)=>{
            return response.json()
        }).then((data)=>{
            if (data.code === 200){
                window.location.href='/';
            }
        }).catch(function(error){
            console.log(error)
        })
    }
    onreg = ()=>{
        window.location.href='/reg';
    }
    render = ()=>{
        return (
            <div>
                <h1>百格面试</h1>
                <antd.Input value={this.state.user} onChange={this.handleChange.bind(this)} size="large" placeholder="手机号或邮箱" />
                <antd.Input type="password" value={this.state.pwd} onChange={this.handleChange1.bind(this)} size="large" placeholder="密码" />
                <antd.Button onClick={this.loginon} type="primary">登录</antd.Button>
                <antd.Button onClick={this.onreg} type="link">还没有账号，去注册</antd.Button>
                <TimeNow />
            </div> )
    }
}
ReactDOM.render( <MessageBox/>,
    document.getElementById('formlogin'),
)
