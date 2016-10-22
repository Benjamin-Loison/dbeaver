/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2016 Serge Rieder (serge@jkiss.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (version 2)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.jkiss.dbeaver.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.jkiss.dbeaver.core.DBeaverUI;

public class EditObjectDialog extends TrayDialog {

    private final IDialogPage dialogPage;

    public EditObjectDialog(Shell shell, IDialogPage dialogPage)
    {
        super(shell);
        this.dialogPage = dialogPage;
        //setHelpAvailable(false);
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        getShell().setText(dialogPage.getTitle());
        Composite group = (Composite) super.createDialogArea(parent);
        GridData gd = new GridData(GridData.FILL_BOTH);
        group.setLayoutData(gd);

        dialogPage.createControl(group);

        return group;
    }

    public static boolean showDialog(IDialogPage dialogPage) {
        return showDialog(DBeaverUI.getActiveWorkbenchShell(), dialogPage);
    }

    public static boolean showDialog(Shell shell, IDialogPage dialogPage) {
        EditObjectDialog dialog = new EditObjectDialog(shell, dialogPage);
        return dialog.open() == IDialogConstants.OK_ID;
    }
}
