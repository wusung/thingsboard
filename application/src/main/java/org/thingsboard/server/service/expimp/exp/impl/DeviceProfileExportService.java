/**
 * Copyright © 2016-2022 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.expimp.exp.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.export.EntityExportData;
import org.thingsboard.server.common.data.export.impl.DeviceProfileExportData;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.queue.util.TbCoreComponent;
import org.thingsboard.server.service.expimp.exp.EntityExportService;

@Service
@TbCoreComponent
@RequiredArgsConstructor
public class DeviceProfileExportService implements EntityExportService<DeviceProfileId, DeviceProfile> {

    private final DeviceProfileService deviceProfileService;


    @Override
    public EntityExportData<DeviceProfile> getExportData(TenantId tenantId, DeviceProfileId deviceProfileId) {
        DeviceProfileExportData exportData = new DeviceProfileExportData();
        exportData.setDeviceProfile(deviceProfileService.findDeviceProfileById(tenantId, deviceProfileId));
        return exportData;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.DEVICE_PROFILE;
    }

}
