/*
 * Copyright 2010 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

Ext.onReady(function(){

    Ext.app.REMOTING_API.enableBuffer = 0;
    Ext.Direct.addProvider(Ext.app.REMOTING_API);

    // provide feedback for any errors
    Ext.QuickTips.init();

   var languagesStore = new Ext.data.SimpleStore( {
    fields: ['name'],
    data: [['Java'], ['Javascript'], ['C++'], ['Perl'], ['Python'], ['Groovy'], ['Scala']]
  }) 
  
  var form = new Ext.FormPanel({    
    renderTo: Ext.getBody(),
    frame: true,
    fileUpload : true,
    width: 500,
    labelWidth: 180,
    defaults: {
      width: 300
    },
    defaultType: 'textfield',      
    items: [
      {
        xtype: 'datefield',
        fieldLabel: 'Pick a date',
        name: 'datefield'
      },
      {
        xtype: 'combo',
        name: 'combo',
        fieldLabel: 'Favourite language',
        mode: 'local',
        store: languagesStore,
        displayField: 'name',
        forceSelection: true,
        triggerAction: 'all',
        valueField: 'name'
      },
      {
        xtype: 'fileuploadfield',
        buttonOnly: false,
        id: 'form-file',
        fieldLabel: 'File (MUST be a text file)',
        name: 'fileUpload',
        buttonCfg: {
          text: '...'
        }
      },
      textArea1 = new Ext.form.TextArea( {
        name: 'textArea', 
        fieldLabel: "File contents",
        height: 100,
        disabled: true
      }),
      {
        xtype: 'checkbox',
        fieldLabel: 'Check if you like ExtDirectSpring!',
        name : 'checkbox',
        width: 15 
      }
    ],
    api: {        
      submit: uploadController.uploadTest
    },    
    buttons: [ 
      {
        text: "Submit",
        handler: function() {
          form.getForm().submit({
            success: function(form, action) {    
              textArea1.setValue( action.result.fileContents);
            },
            failure: function(form, action) {
              switch (action.failureType) {
                case Ext.form.Action.CLIENT_INVALID:
                  Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
                  break;
                case Ext.form.Action.CONNECT_FAILURE:
                  Ext.Msg.alert('Failure', 'Ajax communication failed');
                  break;
                case Ext.form.Action.SERVER_INVALID:
                  Ext.Msg.alert('Failure', action.result);
              }
            }
          });
          
        }
      },
      {
        text: "Reset",
        handler: function(){
          form.getForm().reset();
        }
      }
    ]
  });
  
  
  

});