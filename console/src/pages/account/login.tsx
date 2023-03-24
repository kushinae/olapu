import React, {useLayoutEffect, useState} from "react";
import {Button, Form, Input, Modal, Space} from "antd";
import {getCookie} from "@/utils/cookie";
import api from "@/api";
import {LoginParam} from "@/api/interfaces";

const listener: Record<string, React.Dispatch<React.SetStateAction<boolean>>> = {};

export const openLoginModal = () => {
  listener.setVisible(true);
}

interface IFormField {
  username: string;
  password: string;
  nickname: string;
}

export default () => {
  const [isOpen, setOpen] = useState(false);
  const [form] = Form.useForm<IFormField>();
  const [submitLoading, setLoading] = useState(false);
  // const [isLogin, setLogin] = useState(() => !!getCookie('nickname'));
  const [isLogin, setLogin] = useState(false);

  useLayoutEffect(() => {
    listener.setVisible = setOpen;
    return () => {
      Reflect.deleteProperty(listener, 'setVisible');
    }
  });

  const handlerRegister = () => {
    api.registerAccount({
      "username": form.getFieldValue("username"),
      "password": form.getFieldValue("password"),
      "nickname": form.getFieldValue("nickname"),
    });
  }

  const renderLoginForm = () => {
    return (
      <Form<IFormField>
        form={form}
        hidden={isLogin}
        preserve={false}
        layout='horizontal'
        wrapperCol={{ span: 24 }}
        autoComplete="off"
        onFinish={(payload: LoginParam) => {
          console.log(payload);
          const login = api.login(payload);
          console.log(login);
        }}
      >
        <Form.Item
          label=""
          name="username"
          rules={[
            {
              required: true,
              message: '账号不能为空',
            },
          ]}
        >
          <Input placeholder="请输入注册账号,该帐号将用于登陆" bordered={false} />
        </Form.Item>
        <Form.Item
          label=""
          name="nickname"
          rules={[
            {
              required: true,
              message: '昵称不能为空',
            },
          ]}
        >
          <Input placeholder="请输入用户昵称,该昵称将用于显示" bordered={false} />
        </Form.Item>
        <Form.Item
          label=""
          name="password"
          rules={[
            {
              required: true,
              message: '密码不能为空',
            },
          ]}
        >
          <Input.Password className="dt-input-borderless" placeholder="请输入密码" bordered={false} />
        </Form.Item>
        <Form.Item>
          <Space wrap>
            <Button className="dt-button" loading={submitLoading} block type="primary" htmlType='submit'>
              登录
            </Button>
            <Button className="dt-button" onClick={() => {handlerRegister()}} loading={submitLoading} block type="link">
              注册
            </Button>
          </Space>
        </Form.Item>
      </Form>
    );
  };

  return (
    <>
      <Modal
        className="dt-login"
        title={'欢迎登录 Olapu'}
        open={isOpen}
        footer={null}
        destroyOnClose
        onCancel={() => setOpen(false)}
      >
        {renderLoginForm()}
      </Modal>
    </>
  )
}