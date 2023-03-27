import React, {useLayoutEffect, useState} from "react";
import {Button, Form, Input, message, Modal, Space, Tabs} from "antd";
import api from "@/api";
import {LoginParam, LoginResult} from "@/api/interfaces";
import Constant from "@/commons/constant";

const listener: Record<string, React.Dispatch<React.SetStateAction<boolean>>> = {};

export const openLoginModal = () => {
  listener.setVisible(true);
}

interface IFormField {
  username: string;
  password: string;
  nickname: string;
}

const loginStorage = (loginData: LoginResult) => {
  localStorage.setItem(Constant.Authorization.X_Access_Token, loginData.access_token);
  localStorage.setItem(Constant.Authorization.Nickname, loginData.nickname);
  localStorage.setItem(Constant.Authorization.Avatar, loginData.avatar);
}

export const logoutStorage = () => {
  localStorage.removeItem(Constant.Authorization.X_Access_Token);
  localStorage.removeItem(Constant.Authorization.Nickname);
  localStorage.removeItem(Constant.Authorization.Avatar);
}

export default () => {
  const [isOpen, setOpen] = useState(false);
  const [loginForm] = Form.useForm<IFormField>();
  const [registerForm] = Form.useForm<IFormField>();
  const [submitLoading, setLoading] = useState(false);
  const [activeKey, setActiveKey] = useState<string>('login');

  useLayoutEffect(() => {
    listener.setVisible = setOpen;
    return () => {
      Reflect.deleteProperty(listener, 'setVisible');
    }
  });

  const renderLoginForm = () => {
    return (
      <Form<IFormField>
        form={loginForm}
        hidden={activeKey !== 'login'}
        preserve={false}
        layout='horizontal'
        wrapperCol={{ span: 24 }}
        autoComplete="off"
        onFinish={async (payload: LoginParam) => {
          setLoading(true);
          const result: LoginResult = await api.login(payload, () => {
            setLoading(false);
          });
          setLoading(false);
          setOpen(false);
          loginStorage(result);
          window.location.reload();
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
          </Space>
        </Form.Item>
      </Form>
    );
  };

  const renderRegisterForm = () => {
    return (
      <Form<IFormField>
        form={registerForm}
        hidden={activeKey !== 'register'}
        preserve={false}
        layout='horizontal'
        wrapperCol={{ span: 24 }}
        autoComplete="off"
        onFinish={async () => {
          await api.registerAccount({
            "username": registerForm.getFieldValue("username"),
            "password": registerForm.getFieldValue("password"),
            "nickname": registerForm.getFieldValue("nickname"),
          });
          loginForm.setFieldValue('username', registerForm.getFieldValue('username'));
          registerForm.resetFields();
          setActiveKey('login');
          await message.success('注册成功');
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
        <Tabs
          activeKey={activeKey}
          onChange={(key: 'login' | 'register' | string) => {
            setActiveKey(key);
          }}
          items={[
              {
                label: '登陆',
                key: 'login',
                children: renderLoginForm()
              },
              {
                label: '注册',
                key: 'register',
                children: renderRegisterForm()
              }
            ]}
        />
      </Modal>
    </>
  )
}