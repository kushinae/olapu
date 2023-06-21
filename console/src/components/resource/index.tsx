import { Header, Content } from '@dtinsight/molecule/esm/workbench/sidebar';
import {ResourceProps} from "@/components/typings";
import {ActionBar} from "@dtinsight/molecule/esm/components";
import React, {useState} from "react";
import {FolderTree} from "@dtinsight/molecule/esm/workbench/sidebar/explore";
import {jobTree} from "@/service/job_tree";
import { connect } from '@dtinsight/molecule/esm/react';

const FolderTreeView = connect(jobTree, FolderTree);

interface ResourceViewProps {
  resource: ResourceProps;
  title: string;
}

const Resource: React.FC<ResourceViewProps> = ({resource, title}) => {

  const [expandKeys, setExpandKeys] = useState<string[]>([]);

  const handleOnExpandKeys = (keys: string[]) => {
    console.log('handleOnExpandKeys', keys);
    setExpandKeys(keys);
  }

  const handleRightClick = () => {
    console.log('handleRightClick');
  }

  const handleSelect = () => {
    console.log('handleSelect');
  }

  const handleOnLoadData = () => {
    console.log('handleOnLoadData');
  }

  const handleOnClickContextMenu = () => {
    console.log('handleOnClickContextMenu');
  }

  return (
    <>
      <div className="resource_container">
        <div className="header">
          <Header
            title={title}
            toolbar={<ActionBar data={resource.headerToolBar} />}
          />
        </div>
        <div className="content_container">
          <Content>
            <div className="content">
              <FolderTreeView
                onExpandKeys={handleOnExpandKeys}
                expandKeys={expandKeys}
                onRightClick={handleRightClick}
                draggable={false}
                onSelectFile={handleSelect}
                onLoadData={handleOnLoadData}
                onClickContextMenu={handleOnClickContextMenu}
                // entry={entry}
                panel={resource.panel}
              />
            </div>
          </Content>
        </div>
      </div>
    </>
  );
}

export {Resource};