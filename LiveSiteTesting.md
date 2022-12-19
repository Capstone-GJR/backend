## Live Site Tests Performed

## Troubleshoot Register path 
- add corsRegistry instead of cors configuration 
  - new error 
  - ![](../../../../../var/folders/fk/8ht2dcm12ygchg11r8mmfs2h0000gn/T/TemporaryItems/NSIRD_screencaptureui_7L656w/Screenshot 2022-12-19 at 11.38.58 AM.png)
  - BUT not register path is blocked by cors!!!! 

With no cors on filter and no cors config... 
- login(authenticate) is the only path blocked by cors. 

### User 
- Register new user 
  - /success
- Login User 
  - FAIL 
    - CORS error 
- Edit User 
  - /success
- Delete User 
  - !!! Test not performed

### Spaces 
- Add new space 
  - /success
- Edit Space
  - /success
- Delete Space 
  - /success

### Totes 
- Add 
  - Error received 
    - ![](../../../../../var/folders/fk/8ht2dcm12ygchg11r8mmfs2h0000gn/T/TemporaryItems/NSIRD_screencaptureui_1uCk2e/Screenshot 2022-12-19 at 11.01.10 AM.png)
- Edit
- Delete