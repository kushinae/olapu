import styled from "styled-components";

export const Datasource = styled.div`
  .datasource_content {
    margin: 13px;
  }
  max-height: 100%;
  overflow-y: auto;
`;

export const DatasourceLabelLayout = styled.div`
  .datasource {
    cursor: pointer;
    display: flex;
    align-items: center;
    height: 30px;
    :hover {
      //background-color: #272b33;
    }

    * {
      margin-right: 2px;
    }
  }
  
  
  .database {
    margin-left: 5px;
  }
`

export const DatabaseLabelLayout = styled.div`
  .database {
    cursor: pointer;
    display: flex;
    align-items: center;
    height: 30px;
    :hover {
      //background-color: #272b33;
    }

    * {
      margin-right: 2px;
    }
  }
  
  
  .database {
    margin-left: 5px;
  }
`

export const TableLabelLayout = styled.div`
  .table {
    cursor: pointer;
    display: flex;
    align-items: center;
    height: 30px;
    :hover {
      //background-color: #272b33;
    }

    * {
      margin-right: 2px;
    }
  }
  
  
  .table {
    margin-left: 10px;
  }
`

export const ColumnLabelLayout = styled.div`
  .column {
    cursor: pointer;
    display: flex;
    align-items: center;
    height: 30px;

    :hover {
      //background-color: #272b33;
    }

    * {
      margin-right: 2px;
    }
  }


  .column {
    margin-left: 15px;

    .column-detail {
      .datatype {
        color: #aeb2bb;
      }
    }
  }
`