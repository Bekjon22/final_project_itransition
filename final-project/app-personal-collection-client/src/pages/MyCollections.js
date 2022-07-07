import React, {useEffect, useState} from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Modal, ModalBody, ModalHeader, Table} from "reactstrap";
import PrimarySearchAppBar from "../component/Navbar";
import {API_PATH, TOKEN} from "../component/Constants";
import {CSVLink, CSVDownload} from "react-csv";
import {FormControl, FormHelperText, Input, InputLabel} from '@mui/material';
import {toast} from "react-toastify";
import Button from "@mui/material/Button";


const MyCollections = () => {
    const [client, setClient] = useState([])
    const [disable, setDisable] = useState(false)
    const [photo, setPhoto] = useState()


    const config = {
        headers: {Authorization: `Bearer ` + localStorage.getItem(TOKEN)}
    };

    const getMyCollections = () => {

        axios.get(API_PATH + '/collection/get-all-by-user', config).then(res => {
            console.log(res.data.data)
            setClient(res.data.data)
        }).catch((error) => {
            console.log(error.data)
        })
    }


    // const getClientCusField = () => {
    //   axios.get(API_PATH + "client/cusFieldTableName",tokenHeader).then(res => {
    //       console.log(res.data.object)
    //       setClientCusField(res.data.object)
    //   })
    // }

    useEffect(() => {

        getMyCollections()

    }, [])


    // function handleChange(e) {
    //     return undefined;
    // }

    const openModal = () => {
        setDisable(!disable)
    }

    const saveCollection = (event, values) => {
        console.log(values)
        // console.log(attachment)
        const material = {
            name: values.name,
            description: values.description,
            photoId: photo,
            productTypeId: values.productTypeId
        }


        axios.post(API_PATH + "product", material, config).then(res => {
            // console.log(res)
            toast.success(res.data.message)
            // getProduct()

        }).catch((err) => {
            // console.log(err.response.data.message)
            toast.error(err.response.data.message)
        })

        openModal()
    }


    function attachmentUpload(e) {
        return undefined;
    }

    function clickCollection() {
        setDisable(true)
    }



    function handlePhoto(event :any) {

        let file = event.target.files[0];

        let forFormData = new FormData();
        forFormData.append("file", file)


        axios.post(API_PATH + "/attachment/upload",forFormData ).then(res => {
            console.log(res.data)
            setPhoto(res.data.data)
            // toast.success(res.data.message)


        }).catch((err) => {
            console.log(err.response.data.message)
            // toast.error(err.response.data.message)
        })

    }

    return (

        <div className={"body"}>
            <div className={"navbar"}>
                <PrimarySearchAppBar/>
            </div>
            <div className={"container collection bg-white bg-opacity-50 shadow"}>
                <h1> My collections</h1>

                <Table id={"csv-table"}
                >
                    <thead className={'fw-bolder text-black'}>
                    <tr>
                        <th>
                            #№
                        </th>
                        <th>
                            Name
                        </th>
                        <th>
                            Topic
                        </th>
                        <th>
                            Description
                        </th>

                    </tr>
                    </thead>
                    <tbody className={'fw-bold text-dark'}>
                    {client.map((value, index) => {
                        console.log(value)

                        function rowClick() {
                            console.log("click-row-co-li")
                        }

                        return <tr style={{cursor: 'pointer'}} onClick={rowClick}>
                            <td>{index + 1}</td>
                            <td>{value.name}</td>
                            <td>{value.topic}</td>
                            <td>{value.description}</td>
                        </tr>

                    })}
                    </tbody>
                </Table>

            </div>
            <div className={"mx-lg-1"}>
                <CSVLink
                    className="item-btn btn btn-info mx-auto d-block"
                    data={client}
                    filename={"My Collections.csv"}
                    target="_blank"
                >
                    Download csv
                </CSVLink>

                <Button onClick={clickCollection}>add</Button>

            </div>
            <div>
                <Modal isOpen={disable}>
                    <ModalHeader toggle={() => {
                        openModal()
                    }}>
                        Add Collection
                    </ModalHeader>
                    <ModalBody className={"modal-body"}>
                        <FormControl>
                            <label htmlFor="my-input1">Name</label>
                            <Input id={"my-input1"} type={"text"} name={'name'}/>

                            <label htmlFor="my-input">Description</label>
                            <Input required={'true'} id="my-input" type={"text"} name={'description'}/>

                            <label htmlFor="my-input">Topics</label>
                            <select id="my-input">
                                <option value="books">BOOKS</option>
                                <option value="signs">SIGNS</option>
                                <option value="phone">PHONE</option>
                                <option value="whisky">WHISKY</option>
                            </select>

                            <label htmlFor="my-input">Photo</label>
                            <Input required={'true'} id="my-input" type={"file"} onChange={handlePhoto}/>

                            <Button className={'mt-4'} onClick={saveCollection}> Submit</Button>

                        </FormControl>
                    </ModalBody>
                </Modal>
            </div>
        </div>


    );
};

export default MyCollections;